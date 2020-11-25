def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline {
        agent any
        stages {
            stage('print') {
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
