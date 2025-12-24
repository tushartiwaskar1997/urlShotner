pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    environment {
        IMAGE_NAME = 'imagecreatedbypiple'
        TAG_NAME = 'latest'
        CONTAINER_NAME = "%IMAGE_NAME%_${BUILD_NUMBER}"
        BUILD_NUMBER_TRACK = ${BUILD_NUMBER};
    }

    stages {
        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('building docker image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:V%BUILD_NUMBER_TRACK% .'
            }
        }

        stage('create the container of the image') {
            steps {
                bat 'docker run -d --name CONTAINER_NAME %IMAGE_NAME%:V%BUILD_NUMBER_TRACK%'
            }
        }
    }
}
