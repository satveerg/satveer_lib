pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def filecontent=libraryResource "com/marriott/platform/Routes.yml"
	                def pipelineRulesList = yaml.load(filecontent)
                   
               }
           }
       }
   }
}
