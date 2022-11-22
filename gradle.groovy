def buildGradle(){
    sh "chmod +x gradlew"
    sh './gradlew build'
}

def sonarGradle(){
    sh './gradlew sonar:sonar \
  -Dsonar.projectKey=ejemplo-gradle2 \
  -Dsonar.host.url=http://sonarqube \
  -Dsonar.login=sqp_c802b263acfa81c1b72bf81411a6b70a58fba27e'
}

def runAndTest(){
    sh './gradlew bootrun &'
}

return this;