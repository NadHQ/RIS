package BusinessLogic;

import DataAccessModels.IMessageRepository;
import DataAccsess.MessageRepository;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@MessageDriven(mappedName="jms/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class MessageDrivenEjb implements MessageListener {
    private IMessageRepository messageRepository = MessageRepository.getInstance();

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String[] receivedStringMessage = msg.getText().split("\n");

                ArrayList<String> sortedMessages = new ArrayList<>(Arrays.asList(receivedStringMessage));
                try {
                    List<String> result = sortList(sortedMessages);
                    messageRepository.saveMessages(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private List<String> sortList(ArrayList<String> messages){
        List<String> resultList = new ArrayList<>();
        for(String message: messages){
                resultList.add(message);
            }
        Collections.sort(resultList, String.CASE_INSENSITIVE_ORDER);
        return resultList;
    }
}
