/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.argos.WS.logica.utiles;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Valentina
 */
public class EmailUtiles {

    private static final String MAIL_HOST = "mail.smtp.host";

    private static final String MAIL_HOST_VALUE = "smtp.gmail.com";

    private static final String TLS_DISPONIBLE = "mail.smtp.starttls.enable";

    private static final String TLS_DISPONIBLE_VALUE = "true";

    private static final String MAIL_SMTP_PORT = "mail.smtp.port";

    private static final String MAIL_SMTP_PORT_VALUE = "587";

    private static final String MAIL_USER = "mail.smtp.user";

    private static final String MAIL_USER_VALUE = "argosplanning@gmail.com";

    private static final String MAIL_AUTH = "mail.smtp.auth";

    private static final String MAIL_AUTH_VALUE = "true";

    private static final String PROTOCOLO = "smtp";

    private static final String MAIL_USER_PASS = "valentina123";




public static void envioMail(String asunto, String mensaje,String emailEnviar) throws MessagingException {
   Properties props = new Properties();

    // Nombre del host de correo, es smtp.gmail.com
    props.setProperty(MAIL_HOST, MAIL_HOST_VALUE);

    // TLS si está disponible
    props.setProperty(TLS_DISPONIBLE, TLS_DISPONIBLE_VALUE);

    // Puerto de gmail para envio de correos
    props.setProperty(MAIL_SMTP_PORT,MAIL_SMTP_PORT_VALUE);

    // Nombre del usuario
    props.setProperty(MAIL_USER, MAIL_USER_VALUE);

    // Si requiere o no usuario y password para conectarse.
    props.setProperty(MAIL_AUTH, MAIL_AUTH_VALUE);
     Session session = Session.getDefaultInstance(props);
    session.setDebug(true);

    MimeMessage message = new MimeMessage(session);
        // Quien envia el correo
    message.setFrom(new InternetAddress(MAIL_USER_VALUE));

    // A quien va dirigido
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailEnviar));

    message.setSubject(asunto);
    message.setText(mensaje);
    Transport t = session.getTransport(PROTOCOLO);
    t.connect(MAIL_USER_VALUE, MAIL_USER_PASS);
    t.sendMessage(message,message.getAllRecipients());
    t.close();

}

}
