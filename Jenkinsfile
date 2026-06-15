pipeline {
    agent any

    // 1. Periodically check for updates from Git every 5 minutes
    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        // 2. Automatically build and test using your working test profile
        stage('Build & Test') {
            steps {
                sh './mvnw test -Dspring.profiles.active=test --no-transfer-progress'
            }
        }

        // 3. Run your working Ansible Playbook directly on success
        stage('Deploy to Web Server') {
            steps {
                sh 'ansible-playbook -i docker/hosts.ini docker/deploy.yaml'
            }
        }
    }

    // 4. Email notifications on failure
    post {
        failure {
            emailext (
                subject: "❌ BUILD FAILED: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
                body: "The build failed. Check the logs here: ${env.BUILD_URL}",
                to: "srengty@gmail.com",
                recipientProviders: [culprits()]
            )
        }
    }
}
