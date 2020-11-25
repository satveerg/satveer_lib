#!/usr/local/bin/groovy
import org.yaml.snakeyaml.Yaml
def call(String appBranchName) {
	def yaml = new Yaml()
	def environment = ''
	println("YAML object to read pipeline rules has been created")
    def filecontent=libraryResource "com/marriott/platform/Routes.yml"
	  def pipelineRulesList = yaml.load(filecontent)
	println "Pipeline rules file loaded - " +pipelineRulesList
	
	pipelineRulesList.branchrules.each {

         branchrules->
             def branchName = branchrules.value.branchname
                 environment = branchrules.value.environment

             println "check if branch name is in list - " + branchName
	     println "check if environment name is in list - " + environment

             if ( appBranchName==~branchName ) {
             println "check if environment name is in list - " + environment
             return environment
             }
	}
}

