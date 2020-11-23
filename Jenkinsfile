pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def filecontent=libraryResource "marriott/Routes.yml"
	                def pipelineRulesList = yaml.load(filecontent)
                   
               }
           }
       }
   }
}
