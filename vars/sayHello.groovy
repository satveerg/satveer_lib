def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        environment {
            BRANCH_NAME = "${GIT_BRANCH.split("/")[1]}"
            output = readYaml('$BRANCH_NAME')
        }
        stages {
            stage('call') {
                steps {
                    script {
                       sh '''
                       echo This environment name is $output
                       echo $BRANCH_NAME
                        '''
                    }
                }
            }
            stage('when') {
                when {
                    expression env.output != null
                }
                steps {
                    sh 'echo exectuting when'
                }
            }
        }
    }
}
