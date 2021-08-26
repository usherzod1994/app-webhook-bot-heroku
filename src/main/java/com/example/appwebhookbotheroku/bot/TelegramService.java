package com.example.appwebhookbotheroku.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {
    SendMessage showMenu(Update update);

    SendLocation showAddress(Update update);

    SendPhoto showImage(Update update);

    EditMessageText setPhoneNumber(Update update);

    EditMessageText showAllCourses(Update update);

    DeleteMessage deletePhoneNumber(Update update);

    EditMessageText setFirstName(Update update);

    DeleteMessage deleteFirstNameMessage(Update update);

    EditMessageText setLastName(Update update);

    DeleteMessage deleteLastNameMessage(Update update);

    EditMessageText setBirthDate(Update update);

    DeleteMessage deleteBirthDate(Update update);

    EditMessageText backMain(Update update);

    SendMessage backMain2(Update update);

    EditMessageText myProfile(Update update);

    SendMessage showMyProfile(Update update);

    DeleteMessage deleteTopMessage(Update update);
}
