def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        environment {
            BRANCH_NAME = "${env.BRANCH_NAME}"
            output = readYaml("$BRANCH_NAME")
        }
        stages {
            stage('call') {
                steps {
                       sh '''
                       echo Branch name is $BRANCH_NAME
                       echo env name is $output
                        '''
                }
            }
            stage('when') {
                when {
                    expression {
                        return env.output != null
                    }
                }
                steps {
                    sh 'echo exectuting when'
                }
            }
        }
    }
}
