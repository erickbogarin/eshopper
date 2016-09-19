package br.com.eshopper.ecommerce.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class AmazonSaver {
	
	@Autowired
	private Environment environment;
	
	public String write(String baseFolder, MultipartFile multipartFile) {
		String bucketName = "erickbogarin.com.br/produtos";
		String key = multipartFile.getOriginalFilename();
		
		AmazonS3Client s3 = client();
		try {
			s3.putObject(new PutObjectRequest(bucketName, key, multipartFile.getInputStream(), new ObjectMetadata())
					.withCannedAcl(CannedAccessControlList.PublicRead));

			return s3.getUrl(bucketName, key).toString();
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	private AmazonS3Client client() {
		AWSCredentials credentials = new BasicAWSCredentials(
				environment.getProperty("AWS_ACCES_KEY"),
				environment.getProperty("AWS_SECRET_KEY"));
		
		AmazonS3Client newClient = new AmazonS3Client(credentials, new ClientConfiguration());
		newClient.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
		newClient.setEndpoint("https://s3-sa-east-1.amazonaws.com");
		
		return newClient;
	}
	
}
