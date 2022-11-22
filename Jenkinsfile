def mvn_groovyScript
def grdl_groovyScript

pipeline {
    agent any
    tools{
        gradle 'grdl'
        maven 'maven'
    }

    parameters{
        choice(name: 'tools_', choices: ['Gradle','Maven'], description: 'Elegir Opción: ')
    }

    stages {
        stage('Load Scripts'){
            steps{
                script{
                    mvn_groovyScript = load "maven.groovy"
                    grdl_groovyScript = load "gradle.groovy"
                }
            }
        }

       //MAVEN------------------------------------------------------------
        stage('Maven: Build & Test') {
            when {
                expression {
                    params.tools_ == 'Maven'
                }
            }
            steps {
                script {
                    mvn_groovyScript.cInstall();
                }
            }
        }

        stage('Maven: Sonar') {
            when {
                expression {
                    params.tools_ == 'Maven'
                }
            }
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sonar-jenkins') {
                    script {
                        mvn_groovyScript.sonarMaven
                    }
                }
            }
        }

        //GRADLE-----------------------------------------------------------
        stage('Gradle: Build & test') {
            when {
                expression {
                    params.tools_ == 'Gradle'
                }
            }
            steps {
                script {
                    grdl_groovyScript.buildGradle()
                }
            }
        }

        stage('Gradle: Sonar') {
            when {
                expression {
                    params.tools_ == 'Gradle'
                }
            }

            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sonar-jenkins') {
                    script {
                        grdl_groovyScript.sonarGradle()
                    }
                }
            }
        }
    }
}