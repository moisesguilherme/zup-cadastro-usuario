pipeline {
    agent any
    stages {
        stage("verify tooling"){
            steps {
                echo 'teste'
                sh '''
                   ./mvnw clean package
                  '''
            }
        }
    }
    stage('SonarQube Analysis') {
    	def scannerHome = tool 'SonarScanner';
        withSonarQubeEnv() {
            sh "${scannerHome}/bin/sonar-scanner"
        }
    }
}