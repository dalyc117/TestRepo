pipeline {
    agent any

    tools {
        git 'Default'
    }

    stages {
        stage('GetProject') {
            steps {
                git branch: 'main', url: 'https://github.com/dalyc117/TestRepo.git'
            }
        }
        stage('Build') {
            steps {
                withMaven(maven: 'maven') {
                    sh "mvn clean:clean -X"
    
                    sh "mvn dependency:copy-dependencies"
    
                    sh "mvn compiler:compile"
                }
            }
        }

        stage('Test') {
            steps {
                withMaven(maven: 'maven') {
                    sh "mvn surefire:test"
                }
            }
        }

        stage('Package'){
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn package'
                }
            }
        }

        stage('Archive'){
            steps {
                archiveArtifacts allowEmptyArchive: true,
                    artifacts:'**/VFC*.war'
            }
        }

        stage('Deploy'){
            steps {
                echo "Initiating Deployment"
                sh 'docker build -f Dockerfile -t vfc . '
            }
        }
    }
}
