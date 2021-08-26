package com.example.appwebhookbotheroku.service;

import com.example.appwebhookbotheroku.bot.TelegramService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramServiceImpl<T> implements TelegramService {
    @Override
    public SendMessage showMenu(Update update) {

        String ADDRESS_US_KR = "Бизнинг манзил";

        String CONNECT_TO_ADMIN_KR = "Админ билан боғланиш";
//        SendMessage sendMessage = new SendMessage().setParseMode(ParseMode.MARKDOWN).setChatId(update.getMessage().getChatId());
        SendMessage sendMessage = new SendMessage(String.valueOf(update.getMessage().getChatId()),"");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button2.setText("Курслар");
        button3.setText(CONNECT_TO_ADMIN_KR);
        button4.setText(ADDRESS_US_KR);

        button2.setCallbackData("Course");
        button3.setUrl("https://t.me/khalilovabbos");
        button4.setCallbackData("Address");

        row2.add(button2);
        row3.add(button3);
        row4.add(button4);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        inlineKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setText("Botga hush kelibsiz ");
        return sendMessage;

    }

    @Override
    public SendLocation showAddress(Update update) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        sendLocation.setLatitude(38.845825);
        sendLocation.setLongitude(65.784897);
        return sendLocation;
    }

    @Override
    public SendPhoto showImage(Update update) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        String text = update.getMessage().getText();

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setParseMode(ParseMode.MARKDOWN);
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        try {
            URL url = null;
            url = new URL("https://tezkor.uz/api/uploads/41afcdf3-fc43-4795-9a9b-30ade4ea57bb.jpg");
//            url = new URL("https://t.me/test123ee88888/6");
            InputFile inputFile = new InputFile();
            inputFile.setMedia(new ByteArrayInputStream(readAllBytes(url.openStream())),"Sherzod");
            sendPhoto.setPhoto(inputFile);
//            "sanjar", new ByteArrayInputStream(readAllBytes(url.openStream()))
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendPhoto.setCaption(text);
        button1.setText("Yuborish");
        button2.setText("O'chirish");
        button3.setText("Orqaga");
        button1.setCallbackData("SendReklamaId#");
        button2.setCallbackData("DeleteReklamaId#");
        button3.setCallbackData("BackMain2");
        row.add(button1);
        row.add(button2);
        row1.add(button3);
        rows.add(row);
        rows.add(row1);
        inlineKeyboardMarkup.setKeyboard(rows);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;
    }

    private static byte[] readAllBytes(InputStream input) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int numRead;
        byte[] buffer = new byte[16384];
        while ((numRead = input.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, numRead);
        }
        return out.toByteArray();
    }

    @Override
    public EditMessageText setPhoneNumber(Update update) {
        return null;
    }

    @Override
    public EditMessageText showAllCourses(Update update) {
        return null;
    }

    @Override
    public DeleteMessage deletePhoneNumber(Update update) {
        return null;
    }

    @Override
    public EditMessageText setFirstName(Update update) {
        return null;
    }

    @Override
    public DeleteMessage deleteFirstNameMessage(Update update) {
        return null;
    }

    @Override
    public EditMessageText setLastName(Update update) {
        return null;
    }

    @Override
    public DeleteMessage deleteLastNameMessage(Update update) {
        return null;
    }

    @Override
    public EditMessageText setBirthDate(Update update) {
        return null;
    }

    @Override
    public DeleteMessage deleteBirthDate(Update update) {

        return null;
    }

    @Override
    public EditMessageText backMain(Update update) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        String ADDRESS_US_KR = "Бизнинг манзил";

        String CONNECT_TO_ADMIN_KR = "Админ билан боғланиш";
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());

        editMessageText.setText("Сизнинг ID: " + update.getCallbackQuery().getFrom().getId() + "\n\n" +
                "@csacademy_bot га хуш келибсиз!\n\n" +
                "➡️" + " @csacademy_uz" + " каналида янгиликларимизни кузатиб боринг\n\n");
        button2.setText("Курслар");
        button3.setText(CONNECT_TO_ADMIN_KR);
        button4.setText(ADDRESS_US_KR);

        button2.setCallbackData("Course");
        button3.setUrl("https://t.me/khalilovabbos");
        button4.setCallbackData("Address");
        row2.add(button2);
        row3.add(button3);
        row4.add(button4);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        inlineKeyboardMarkup.setKeyboard(rows);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }

    @Override
    public SendMessage backMain2(Update update) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();


        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        String ADDRESS_US_KR = "Бизнинг манзил";

        String CONNECT_TO_ADMIN_KR = "Админ билан боғланиш";
        sendMessage.setText("Сизнинг ID: " + update.getCallbackQuery().getFrom().getId() + "\n\n" +
                "@csacademy_bot га хуш келибсиз!\n\n" +
                "➡️" + " @csacademy_uz" + "  каналида янгиликларимизни кузатиб боринг\n\n");

        button2.setText("Курслар");
        button3.setText(CONNECT_TO_ADMIN_KR);
        button4.setText(ADDRESS_US_KR);

        button2.setCallbackData("Course");
        button3.setUrl("https://t.me/khalilovabbos");
        button4.setCallbackData("Address");
        row2.add(button2);
        row3.add(button3);
        row4.add(button4);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        inlineKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public EditMessageText myProfile(Update update) {
        return null;
    }

    @Override
    public SendMessage showMyProfile(Update update) {
        return null;
    }

    @Override
    public DeleteMessage deleteTopMessage(Update update) {
        return null;
    }
}
