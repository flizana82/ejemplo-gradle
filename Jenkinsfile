pipeline {
    agent any
    parameters{
        choice(name: 'tool', choices: ['Gradle','Maven'],'Elegir Opción')
    }
    stages {
        stage('Build & test') {
            steps {
                echo 'Build & test'
                // script {
                //     sh './mvnw clean compile -e'
                // }
            }
        }
        stage('Sonar') {
            steps {
                echo 'Sonar'

                //withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sonar-jenkins') {
                    // script {
                    //     sh './mvnw clean verify sonar:sonar \
                    //             -Dsonar.projectKey=example-maven2'
                    // }
                //}
            }
        }
        stage('Upload Nexus') {
            steps {
                script {
                    echo 'nexus'
                    //nexusPublisher nexusInstanceId: 'nxs01', nexusRepositoryId: 'ejercicio-clase4-mod4', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'build/DevOpsUsach2020-1.0.0.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
                }
            }
        }
    }
}