/**
 * @author Furkan Aydemir, deerborg
 * @since 2024,
 * @version alpha 1.0 
 */
package AccountForBank;

import java.util.Scanner;
/*
Registration and data entries;
    userId & userIdNo : ID number received and saved from the user
    userPassword & userPasswordNo : Password created and saved by the user
    userName & userNameTag : It does not affect the data. It appeals to the user for realism.

Query and approval checks;
    confirmationForId & confirmationUserID : The identification number entered for the query. Compares with recorded data.
    confirmationPassword & confirmationUserPassword : Password information entered for the query. Compares with recorded data.

Nav operations;
    selectedProcess & selectedUserProcess : Navigating.
    userBalanceAdd : The amount the user wants to deposit.
    userBalanceExtraction : The amount the user wants to withdraw.
    userNewBalance : Current amount after deposit.
    userBalanceExtractionConfirm : Current amount after withdraw.
    userBalance : Wallet.
    backMenu & backMenuSelect : option to return to nav.
*/
public class Main {
    public static void bracket(){
        System.out.println("-------------------------------------");
        // Fast print method. To clear up confusion
    }
    public static void main(String[] args) {
        System.out.println("___Patkia+ Banka hesap olustuma paneli___");
        Scanner userId = new Scanner(System.in);
        System.out.println("Lutfen kimlik numaranizi giriniz: "); 
        Long userIdNo = userId.nextLong(); // ID number saved
        
        
        Scanner userPassword = new Scanner(System.in);
        System.out.println("Rakamlardan olusan yeni sifrenizi giriniz: ");
        int userPasswordNo = userPassword.nextInt(); // Password saved
        
        Scanner userName = new Scanner(System.in);
        System.out.println("Size nasil hitap edelim: ");
        String userNameTag = userName.nextLine(); // Username created. Does not affect data.
        
        bracket();
        System.out.println("Kayit islemi basariyla garceklesti. Giris sayfasina yonlendiriliyorsunuz...."); 
        bracket();
        
        bracket();
        System.out.println("Giris Sayfasi"); 
        bracket();
        
        
        while(true){
        Scanner confirmationForId = new Scanner(System.in);
        System.out.println("Lutfen kimlik numaranizi giriniz: ");
        long confirmationUserID = confirmationForId.nextLong(); // Querying the ID number
        
         if(confirmationUserID != userIdNo){ // Checks for incorrect information.
             System.out.println("Hatali veya kayit edilmemis kimlik bilgisi, lutfen tekrar deneyiniz..");
         }else{ 
             break;
         }
        }
        
        while(true) {
            Scanner confirmationPassword = new Scanner(System.in);
            System.out.println("Sifrenizi giriniz: ");
            int confirmationUserPassword = confirmationPassword.nextInt(); // Querying the ID password.
            
            if (confirmationUserPassword != userPasswordNo){ // Checks for incorrect information.
                System.out.println("Hatali sifre giris islemi yaptiniz lutfen tekrar deneyiniz..");
            }else{
                System.out.println("Basarili sekilde giris yapildi sayin; " + userNameTag);
                break; 
            }
            
        }
        
        
        bracket();
        System.out.println("Hosgeldiniz Sayin; " + userNameTag); 
        bracket();
        
        long userBalance = 0; // Wallet information.
  
        while(true){ // Nav and nav operations.
            System.out.println("Yapmak istediginiz islemi secin: \n (1) - Para Yatirma \n (2) - Para Cekme \n (3) - Kullanici Bilgileri \n (4) - Cikis" );
            Scanner selectedProcess = new Scanner(System.in);
            int selectedUserProcess = selectedProcess.nextInt(); // User choices.
            
                if(selectedUserProcess == 1){ 
                    
                    System.out.println("Islemlere devam etmek icin (1), menuye geri donmek icin (2) seciniz."); // To return to nav again.
                    Scanner backMenu = new Scanner(System.in);
                    int backMenuSelect = backMenu.nextInt();
                    if(backMenuSelect == 2){
                       continue;
                    }else if(backMenuSelect > 2){
                        System.out.println("Lutfen (1) veya (2) seciniz");
                        continue;
                    }
                   System.out.println("Yatirmak istediginiz tutari giriniz: ");
                   Scanner userBalanceAdd = new Scanner(System.in);
                   long userNewBalance = userBalanceAdd.nextLong(); // Deposit for wallet.
                   while(userNewBalance <= 0){ 
                   System.out.println("Eklenen tutar en az 1 (bir) veya daha fazla olmalidir" );
                   System.out.println("Yatirmak istediginiz tutari giriniz: ");
                   userBalanceAdd = new Scanner(System.in);
                   userNewBalance = userBalanceAdd.nextLong();
                        }
                        userBalance += userNewBalance; // Update wallet
                        System.out.println("Para yatirma islemi gerceklesti.. Bakiyeniz: " + userBalance);            
            }
                else if(selectedUserProcess == 2){
                    if(userBalance == 0){ 
                        System.out.println("***Hesabinizdaki net tutar: " + userBalance + " Lutfen para yatirma islemlerini secip yatirim islemlerinizi gerceklestiriniz.***");
                        bracket();
                        continue;
                    }
                    System.out.println("Islemlere devam etmek icin (1), menuye geri donmek icin (2) seciniz.");
                    Scanner backMenu = new Scanner(System.in);
                    int backMenuSelect = backMenu.nextInt();
                    if(backMenuSelect == 2){
                        continue;
                    }else if(backMenuSelect > 2){
                        System.out.println("Lutfen (1) veya (2) seciniz");
                        continue;
                    }
                    System.out.println("Cekmek istediginiz tutari giriniz: ");
                    Scanner userBalanceExtraction = new Scanner(System.in);
                    long userBalanceExtractionConfirm = userBalanceExtraction.nextLong(); // Withdraw for wallet
                    while(userBalanceExtractionConfirm > userBalance){ 
                        System.out.println("Bakiyeniz: " + userBalance + " Lutfen gecerli miktar giriniz");
                        System.out.println("Cekmek istediginiz tutari giriniz: ");
                        userBalanceExtraction = new Scanner(System.in);
                        userBalanceExtractionConfirm = userBalanceExtraction.nextLong();
                    }
                    userBalance -= userBalanceExtractionConfirm; 
                    System.out.println("Para cekme islemi gerceklesti.. Bakiyeniz: " + userBalance);
                }else if(selectedUserProcess == 3){
                    System.out.println("Islemlere devam etmek icin (1), menuye geri donmek icin (2) seciniz.");
                    Scanner backMenu = new Scanner(System.in);
                    int backMenuSelect = backMenu.nextInt();
                    if(backMenuSelect == 2){
                        continue;
                    }else if(backMenuSelect > 2){
                        System.out.println("Lutfen (1) veya (2) seciniz");
                        continue;
                    }
                    bracket();
                    System.out.println("Kullanici adiniz: " + userNameTag + "\nKayitli ID numaraniz: " + userIdNo + "\n Sifre bilgisi: " + userPasswordNo);
                    bracket();
                    
                }
                else if(selectedUserProcess == 4){
                    System.out.println("Guvenli cikis saglaniyor... Bizi sectiginiz icin tesekkur ederiz. Iyi gunler Sayin: " + userNameTag);
                    break; // End the program.
                }
                
        }
    }
}
