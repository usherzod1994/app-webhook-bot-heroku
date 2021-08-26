package com.example.appwebhookbotheroku.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class MyWebHookBot extends TelegramWebhookBot {

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.path}")
    private String botPath;


    @Autowired
    TelegramService telegramService;

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage sendMessage = null;
        SendPhoto sendPhoto = null;
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            log.info("New message from User:{}, chatId: {},  with text: {}",
                    message.getFrom().getUserName(), message.getChatId(), message.getText());
//            sendMessage = new SendMessage(chatId.toString(), "Hi " + update.getMessage().getText());

            SendPhoto sendPhoto1 = telegramService.showImage(update);
            try {
                execute(sendPhoto1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            sendMessage = new SendMessage(chatId.toString(), "Hi " + data);
            System.out.println(data);
            System.out.println(update);
            if (data.startsWith("DeleteReklamaId#")){
                String id = callbackQuery.getId();
                AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
                answerCallbackQuery.setCallbackQueryId(id);
                answerCallbackQuery.setText(data);
                answerCallbackQuery.setShowAlert(true);
                try {
                    execute(answerCallbackQuery);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        return sendMessage;
    }

    @Override
    public String getBotPath() {
        return this.botPath;
    }
}
