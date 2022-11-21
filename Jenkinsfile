def mvn-groovyScript
def grdl-groovy

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
                    mvn-groovyScript = load "maven.groovy"
                    grdl-groovyScript = load "gradle.groovy"
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
                    mvn-groovyScript.cInstall();
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
                          mvn-groovyScript.sonarMaven
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
                    grdl-groovyScript.buildGradle()
                }
            }
        }

        stage('Gradle: Sonar') {
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sonar-jenkins') {
                     script {
                         grdl-groovyScript.sonarGradle()
                     }
                }
            }
        }


        //stage('Upload Nexus') {
            //steps {
                //script {
                    //echo 'nexus'
                    //nexusPublisher nexusInstanceId: 'nxs01', nexusRepositoryId: 'ejercicio-clase4-mod4', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'build/DevOpsUsach2020-1.0.0.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
                //}
            //}
        //}
    }
}