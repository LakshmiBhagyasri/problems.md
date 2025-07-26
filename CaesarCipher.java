// caeser cipher

public class CaesarCipher{
    //Method to encode a message by shifting letters forward
    public static String encode(String message,int shiftAmount){
        return shiftMessage(message,shiftAmount);
    }

    //Method to decode a message by shifting letters backward

    public static String decode(String message,int shiftAmount){
        return shiftMessage(message,-shiftAmount);
    }

    //This method handles both encoding and decoding,based on shift direction

    private static String shiftMessage(String message,int shiftAmount){
        StringBuilder shiftedMessage=new StringBuilder();


        shiftAmount = shiftAmount%26;

        for(char character:message.toCharArray()){

            if(Character.isUpperCase(character)){
                char shiftedChar = (char) ((character-'A'+shiftAmount+26)%26+'A');
                shiftedMessage.append(shiftedChar);
            }
            else if(Character.isLowerCase(character)){
                char shiftedChar =(char)((character-'a'+shiftAmount+26)%26+'a');
                shiftedMessage.append(shiftedChar);
            }
            else{
                shiftedMessage.append(character);
            }
        }
        return shiftedMessage.toString();
    }

    public static void main(String[] args){
        String originalMessage="Hello, Friend!";
        int secretShift=3;

        String encrypted=encode(originalMessage,secretShift);
        System.out.println(encrypted);

        String decrypted = decode(encrypted,secretShift);
        System.out.println(decrypted);
    }
}