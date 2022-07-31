pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
              sh "java -jar ${WORKSPACE}/target/movie-info-service-0.0.1-SNAPSHOT.jar"
                echo 'Deploying....'
            }
        }
    }
}
