package DataAccsess;

import DataAccessModels.IMessageRepository;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MessageRepository implements IMessageRepository {
    private static IMessageRepository messageRepository;

    public static IMessageRepository getInstance() {
        if (messageRepository == null) messageRepository = new MessageRepository();
        return messageRepository;
    }

    public void saveMessages(List<String> messages) throws IOException {
        File myFile = new File("/home/zephyr/dev/Java/RIS/Laba4/RIS_4/src/main/resources/let.txt");
        File myFile2 = new File("/home/zephyr/dev/Java/RIS/Laba4/RIS_4/src/main/resources/num.txt");
        FileWriter writer = new FileWriter(myFile, false);
        FileWriter writer1 = new FileWriter(myFile2, false);

        try {
            for (String message : messages) {
                try {
                    if (message.length() == 1)
                        Integer.parseInt(message);
                    else
                        Integer.parseInt(StringUtils.chop(message));
                    writer1.write(message + "\n");
                } catch (NumberFormatException e) {
                    writer.write(message + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
            writer1.close();
        }
    }
}
