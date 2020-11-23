pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def filecontent=libraryResource "com/nbs/remo/Routes.yaml"
	                def pipelineRulesList = yaml.load(filecontent)
                   
               }
           }
       }
   }
}
