def buildGradle(){
    sh './gradlew build'
}

def sonarGradle(){
    sh './gradlew sonarqube \
        -Dsonar.projectKey=ejemplo-gradle'
}

def runAndTest(){
    sh './gradlew bootrun &'
}

return this;