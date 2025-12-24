pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    environment {
        IMAGE_NAME = 'imagecreatedbypiple'
        CONTAINER_NAME = "${IMAGE_NAME}_${BUILD_NUMBER}"
        BUILD_NUMBER_TRACK = "${BUILD_NUMBER}"
    }

    stages {
        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('cleanup stage') {
            steps {
                script {
                    def PREVIOUS_BUILD_NUMBER = env.BUILD_NUMBER.toInteger() - 1
                    def PREVIOUS_IMAGE_NAME = "%IMAGE_NAME%:V${PREVIOUS_BUILD_NUMBER}"
                    def PREVIOUS_CONTAINER_NAME = "%IMAGE_NAME%_${PREVIOUS_BUILD_NUMBER}"

                    echo "removing the image  ${PREVIOUS_IMAGE_NAME}"
                    echo "removing the container ${PREVIOUS_CONTAINER_NAME}"

                    bat  "docker rm -f ${PREVIOUS_CONTAINER_NAME} || exit 0"

                    bat  "docker rmi -f ${PREVIOUS_IMAGE_NAME} || exit 0"
                }
            }
        }

        stage('building docker image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:V%BUILD_NUMBER_TRACK% .'
            }
        }

        stage('create the container of the image') {
            steps {
                bat 'docker run -d --name %CONTAINER_NAME% %IMAGE_NAME%:V%BUILD_NUMBER_TRACK%'
            }
        }
    }
}
