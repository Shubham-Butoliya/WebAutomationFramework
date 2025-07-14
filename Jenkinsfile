pipeline {
    agent any

    options {
        // Disable default SCM checkout to handle it manually
        skipDefaultCheckout(true)
    }

    stages {
        stage('Clean Workspace and Checkout') {
            steps {
                deleteDir() // Clean up workspace

                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        credentialsId: 'PerGithub',
                        url: 'https://github.com/Shubham-Butoliya/WebAutomationFramework'
                    ]]
                )
            }
        }

        stage('Test Execution') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Publish JUnit test results
            junit '**/surefire-reports/*.xml'

            // Archive Extent Report
            archiveArtifacts artifacts: 'test-output/ExtentReport.html', allowEmptyArchive: true
        }
    }
}