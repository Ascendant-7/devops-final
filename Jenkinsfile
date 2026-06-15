pipeline {
    agent any
    
    triggers {
        pollSCM('*/5 * * * *')
    }
    
    stages {
        stage('Build & Test') {
            steps {
                sh './mvnw test -Dspring.profiles.active=test --no-transfer-progress'
            }
        }
        stage('Deploy to Web Server') {
            steps {
                sh 'ansible-playbook -i docker/hosts.ini docker/deploy.yaml'
            }
        }
    }
    
    post {
        success {
            emailext (
                subject: "SUCCESS: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
                body: """The build was successful!
                         View the build details here: ${env.BUILD_URL}""",
                to: 'srengty@gmail.com'
            )
        }
        failure {
            emailext (
                subject: "FAILURE: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
                body: """Attention team, the build has failed.
                         Check the console output here: ${env.BUILD_URL}console""",
                to: 'srengty@gmail.com'
            )
        }
    }
}
