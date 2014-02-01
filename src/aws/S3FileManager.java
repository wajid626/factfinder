package aws;

import java.io.FileInputStream;
import java.io.IOException;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/*
 * 
 * Manages File Upload/Download to ßS3 Bucket
 * 
 */
public class S3FileManager {
	private static final String s3BucketName = "factfinder.healthcare";
	
	public void loadFile(String filePath, String keyName) throws IOException {
		 String existingBucketName = s3BucketName;
		  
		  String amazonFileUploadLocationOriginal=existingBucketName+"/";
		  

		  AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(
				  S3FileManager.class.getResourceAsStream("AwsCredentials.properties")));

		  FileInputStream stream = new FileInputStream(filePath);
		  ObjectMetadata objectMetadata = new ObjectMetadata();
		  PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream, objectMetadata);
		  s3Client.putObject(putObjectRequest);
	 }
	
	public S3ObjectInputStream downloadFile(String fileName, String downloadLocation) throws IOException {

		  String keyName = "/"+"";
		  
		  AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(
				  S3FileManager.class.getResourceAsStream("AwsCredentials.properties")));
		  
		  GetObjectRequest request = new GetObjectRequest(s3BucketName,
		    keyName);
		  S3Object object = s3Client.getObject(request);
		  return object.getObjectContent();
	}
	
}