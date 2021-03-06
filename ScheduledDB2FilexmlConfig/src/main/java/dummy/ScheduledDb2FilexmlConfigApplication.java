package dummy;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@ImportResource("batch-config.xml")
@EnableScheduling
public class ScheduledDb2FilexmlConfigApplication {
	
	@Autowired
	private JobLauncher jobLauncher; 
	
	@Autowired
    private Job job;

	public static void main(String[] args) {
		SpringApplication.run(ScheduledDb2FilexmlConfigApplication.class, args);
	}

	public void perform() throws Exception{
	
	System.out.println("Job Started at :" + new Date());
			JobExecution execution = jobLauncher.run(job, new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters());
	        System.out.println("Execution status: "+ execution.getStatus());
	}

}
