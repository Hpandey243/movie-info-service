pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                //mvn package -Dmaven.test.skip=true
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                // sh './ mvn test'
            }
        }
        stage('Build Docker image') {
            steps {
                 echo 'Build..'
                // sh "docker build -t movie-info-service: ${BUILD_NUMBER} -f Dockerfile.
            }
        }
        stage('Push Docker image') {
           // environment {
             //   DOCKER_HUB_LOGIN = credentials('docker-hub')
           // }
            steps {
                echo 'Deploying....'
           //      sh "docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW"
            //    sh "docker -push  movie-info-service: ${BUILD_NUMBER}"
                
            }
        }
    }
}
