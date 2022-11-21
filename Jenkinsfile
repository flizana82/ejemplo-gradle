def mvn_groovyScript
def grdl_groovyScript

pipeline {
    agent any
    tools{
        gradle 'grdl'
        maven 'maven'
    }
    parameters{
        choice(name: 'tools', choices: ['Gradle','Maven'],'Elegir Opción')
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
                    params.tools == 'maven'
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
                    params.tools == 'maven'
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
                    params.tools == 'gradle'
                }
            }
            steps {
                script {
                    mvn_groovyScript.buildGradle()
                }
            }
        }

        stage('Gradle: Sonar') {
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sonar-jenkins') {
                    script {
                        mvn_groovyScript.sonarGradle()
                    }
                }
            }
        }
    }
}