pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
    }

    parameters {
            string(name: 'BRANCH_NAME', defaultValue: "master")
            string(name: 'GIT_URL', defaultValue: "https://github.com/Evgenz-mr/helloworld.git")
            string(name: 'DOCKER_IMAGE', defaultValue: "")
            string(name: 'DOCKER_TAG', defaultValue: "")
            string(name: 'CRED_GIT', defaultValue: "github")
            string(name: 'DOCKER_CONTAINER', defaultValue: "")
    }

    stages {
        stage('Pull code github') {
            steps {
                git branch: '$BRANCH_NAME',
                credentialsId: '$GIT_URL',
                url: '$GIT_URL'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Create docker image') {
             steps {
                sh "docker build -t $DOCKER_IMAGE:$DOCKER_TAG ."
            }
        }

        stage('docker start') {
             steps {
                sh "docker run --name $DOCKER_CONTAINER $DOCKER_IMAGE:$DOCKER_TAG"
             }
        }

        stage('echo docker_container') {
            steps {
                echo "docker logs $DOCKER_CONTAINER"
            }
        }
    }
}