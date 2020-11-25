def call() {
    pipeline {
        agent any
        stages {
            stage {
                steps {
                    script {
                    sh """
                    echo "India is Great"
                    """
                    }
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
