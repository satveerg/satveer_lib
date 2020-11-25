def call() {
    pipeline {
        agent any
        stages {
            stage {
                steps {
                    sh """
                    echo "India is Great"
                    """
                }
            }
            stage('call') {
                steps {
                    script {
                      readYaml
                      sh 'echo Running library'
                    }
                }
            }
        }
    }
}
