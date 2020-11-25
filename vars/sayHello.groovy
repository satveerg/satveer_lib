def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        define {
            def output = readYaml('sprint-dev-aps')
        }
        stages {
            stage('print') {
                steps {
                    sh """
                    echo "India is Great"
                    """
                }
            }
            stage('call') {
                steps {
                    script {
                       sh '''
                       echo $output
                        echo Running library
                        '''
                    }
                }
            }
        }
    }
}
