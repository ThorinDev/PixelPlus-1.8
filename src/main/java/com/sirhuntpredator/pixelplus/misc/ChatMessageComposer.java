package com.sirhuntpredator.pixelplus.misc;

import java.util.ArrayList;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.client.FMLClientHandler;

import com.sirhuntpredator.pixelplus.PixelPlus;

public class ChatMessageComposer {
    private static IChatComponent CHAT_PREFIX;
    public static String SEPARATION_MESSAGE = "\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC";
    private IChatComponent chatComponent;
    private ArrayList<ChatMessageComposer> appendedMessages;
    
    public ChatMessageComposer(String text) {
        this.chatComponent = new ChatComponentText(text);
    }
    
    public ChatMessageComposer(String text, EnumChatFormatting color) {
        this(text);
        this.addFormatting(color);
    }
    
    public ChatMessageComposer addFormatting(EnumChatFormatting formatting) {
        ChatStyle style = this.chatComponent.getChatStyle();
        switch (formatting) {
        case ITALIC:
            style.setItalic(true);
            break;
        case BOLD:
            style.setBold(true);
            break;
        case UNDERLINE:
            style.setUnderlined(true);
            break;
        case OBFUSCATED:
            style.setObfuscated(true);
            break;
        case STRIKETHROUGH:
            style.setStrikethrough(true);
            break;
        default:
            style.setColor(formatting);
            break;
        }
        this.chatComponent.setChatStyle(style);
        
        return this;
    }
    
    public ChatMessageComposer appendMessage(ChatMessageComposer message) {
        if(this.appendedMessages == null) {
            this.appendedMessages = new ArrayList<ChatMessageComposer>();
        }
        this.appendedMessages.add(message);
        if(message.appendedMessages != null) {
            this.appendedMessages.addAll(message.appendedMessages);
        }
        
        return this;
    }
    
    public ChatMessageComposer makeClickable(ClickEvent.Action action, String execute, ChatMessageComposer description) {
        ChatStyle style = this.chatComponent.getChatStyle();
        
        style.setChatClickEvent(new ClickEvent(action, execute));
        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, description.assembleMessage(false)));
        
        this.chatComponent.setChatStyle(style);
        
        return this;
    }
    
    public ChatMessageComposer makeLink(String url) {
        ChatMessageComposer description = new ChatMessageComposer("Click to visit ", EnumChatFormatting.GRAY);
        description.appendMessage(new ChatMessageComposer(url, EnumChatFormatting.AQUA).addFormatting(EnumChatFormatting.UNDERLINE));
        this.makeClickable(Action.OPEN_URL, url, description);
        
        return this;
    }
    
    public ChatMessageComposer makeHover(ChatMessageComposer text) {
        ChatStyle style = this.chatComponent.getChatStyle();
        
        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, text.assembleMessage(false)));
        
        this.chatComponent.setChatStyle(style);
        
        return this;
    }
    
    public void send() {
        this.send(true);
    }
    
    public void send(boolean prefix) {
        try {
            FMLClientHandler.instance().getClientPlayerEntity().addChatMessage(this.assembleMessage(prefix));
        } catch(Exception e) {
            PixelPlus.instance().logInfo("Failed to send chat message");
            e.printStackTrace();
        }
    }
    
    protected IChatComponent assembleMessage(boolean prefix) {
        IChatComponent result;
        if(prefix) {
            result = CHAT_PREFIX.createCopy();
        } else if(this.appendedMessages == null) {
            return this.chatComponent;
        } else {
            result = new ChatComponentText("");
        }
        
        result.appendSibling(this.chatComponent);
        if(this.appendedMessages != null) {
            for (ChatMessageComposer m : this.appendedMessages) {
                result.appendSibling(m.chatComponent);
            }
        }
        
        return result;
    }
    
    static {
        
        IChatComponent name = new ChatComponentText("PixelPlus");
        name.setChatStyle(new ChatStyle().setBold(true).setColor(EnumChatFormatting.DARK_PURPLE));
        CHAT_PREFIX = new ChatComponentText("[").appendSibling(name).appendSibling(new ChatComponentText("] "));
    }
    
    public static void printSeparationMessage(EnumChatFormatting color) {
        new ChatMessageComposer(SEPARATION_MESSAGE, color).addFormatting(EnumChatFormatting.BOLD).send(false);
    }
}