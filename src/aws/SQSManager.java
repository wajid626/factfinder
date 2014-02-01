package aws;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQSManager {
	private static String _secretKey  = "ahvHtIUpraF+rCJBIu2BFtuog/nBDIQFcsFrSOgz";
	private static String _accessKey  = "AKIAIGCT6NCMWWWCLV6Q";
	private static String _endPoint   = "sqs.us-west-2.amazonaws.com";
	
	public  void sendMessageToSQS(String zipCode) {
		AmazonSQSClient sqs = new AmazonSQSClient(new BasicAWSCredentials(_accessKey, _secretKey));
		sqs.setEndpoint(_endPoint);
		String url = sqs.createQueue(new CreateQueueRequest("weatherq")).getQueueUrl();  
		sqs.sendMessage(new SendMessageRequest(url, "Getting Weather for :" + zipCode));	
	}
	
	public  List<String> getAllMesagesFromSQS() {
		AmazonSQSClient sqs = new AmazonSQSClient(new BasicAWSCredentials(_accessKey, _secretKey));
		sqs.setEndpoint(_endPoint);
		String url = sqs.createQueue(new CreateQueueRequest("FactfinderHealthCare")).getQueueUrl();
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url);
		List<String> msgList = new ArrayList<String>();
		
		while(true) {
			List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
			for(Message msg : messages) {
				msgList.add(msg.getBody());
			}
			if ( messages.size() == 0 ) {
				break;
			}
		}
		return msgList;
	}
}
