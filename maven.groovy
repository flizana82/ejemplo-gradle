

def cInstall(){
    sh './mvnw clean install'
}

def sonarMaven(){
    sh './mvnw clean verify sonar:sonar \
            -Dsonar.projectKey=ejemplo-gradle'

}

return this;