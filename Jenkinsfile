pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                //sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                // sh './gradlew test'
            }
        }
        stage('Build Docker image') {
            steps {
                 echo 'Build..'
                // sh './gradlew docker'
            }
        }
        stage('Push Docker image') {
           // environment {
             //   DOCKER_HUB_LOGIN = credentials('docker-hub')
           // }
            steps {
                echo 'Deploying....'
           //      sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
            //    sh './gradlew dockerPush'
                
            }
        }
    }
}
