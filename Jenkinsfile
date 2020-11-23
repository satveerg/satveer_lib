pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def filecontent=libraryResource "./Routes.yml"
	                def pipelineRulesList = yaml.load(filecontent)
                   
               }
           }
       }
   }
}
