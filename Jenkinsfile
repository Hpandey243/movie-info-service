pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven() {
                sh "mvn clean  -Dmaven.test.failure.ignore "
            }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
              
                echo 'Deploying....'
            }
        }
    }
}
