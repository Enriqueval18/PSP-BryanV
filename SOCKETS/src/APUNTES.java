public class APUNTES {
    //--------------------------------------------TCP-----------------------------------------\\
    //----------------------------------------------------------------------------------------\\
    //flujoSalida.writeInt(numero); = ENVIO ENTEROS
    //----------------------------------------------------------------------------------------\\
    //int resultado = flujoEntrada.readInt(); = LEO ENTEROS
    //----------------------------------------------------------------------------------------\\
    // String resultado = flujoEntrada.readUTF(); = LEO STRING
    //----------------------------------------------------------------------------------------\\
    //flujoSalida.writeUTF(ip); = ESCRIBO STRING
    //----------------------------------------------------------------------------------------\\

    //			int length = inputStream.readInt();
    //			byte[] byteArray = new byte[length];  = CON ESTO RECIBO UNA ARRAY DE ENTEROS
    //			inputStream.readFully(byteArray);
    //			ByteBuffer buffer = ByteBuffer.wrap(byteArray);
    //			int[] intArray = new int[byteArray.length / 4];
    //			for (int i = 0; i < intArray.length; i++) {
    //				intArray[i] = buffer.getInt();
    //			}
    //
    //			// array de int ya convertidor
    //			int[] receivedArray = intArray;
    //
    //			// recibo la array
    //			System.out.println("Array recibido:");
    //			for (int num : receivedArray) {
    //				System.out.print(num + " ");
    //			}
    //			System.out.println();
    //----------------------------------------------------------------------------------------\\






    //-----------------------------------------------UDP--------------------------------------\\
    //----------------------------------------------------------------------------------------\\
    //byte b = (byte) numero;
    //byte[] conversor = new byte[8];   = CON ESTO CONVIERTO DE ENTEROS A BYTES
    //conversor[0] = b;
    //----------------------------------------------------------------------------------------\\Ç
    //byte[] recibidos = new byte[8];  = CON ESTO CONVIERTO DE BYTES A ENTEROS
    // byte[] hh = recibo.getData();
    // int numero2 = hh[0];
    //----------------------------------------------------------------------------------------\\
    //byte[] conversor = ip.getBytes();
    //String hola = new String(recibo.getData(),0,recibo.getLength()).trim(); =     CON ESTO SE CONVIERTE DE BYTES A STRING
    //----------------------------------------------------------------------------------------\\

    //                int[] receivedArray = bytesToIntArray(receivePacket.getData(), receivePacket.getLength());
    //
    //                System.out.println("Array recibido del cliente:");
    //                for (int num : receivedArray) {
    //                    System.out.print(num + " ");
    //                }
    //                System.out.println();
    //    private static int[] bytesToIntArray(byte[] bytes, int length) {
    //        ByteBuffer buffer = ByteBuffer.wrap(bytes, 0, length);     == DE BYTES A ARRAY
    //        int[] intArray = new int[length / 4]; // Cada entero ocupa 4 bytes
    //        for (int i = 0; i < intArray.length; i++) {
    //            intArray[i] = buffer.getInt();
    //        }
    //        return intArray;
    //    }
    //----------------------------------------------------------------------------------------\\

}
