package nl.itvitae.markvdvliert.Phones.services;


import nl.itvitae.markvdvliert.Phones.models.Phone;
import nl.itvitae.markvdvliert.Phones.models.SendForm;

import java.util.Arrays;
import java.util.List;

public class PhoneService {

    private static List<Phone> phones = List.of(
            new Phone("Huawei", "P30", 697, 1, "6.47\" FHD+ (2340x1080) OLED, Kirin 980 Octa-Core (2x Cortex-A76 2.6GHz+ 2x Cortex-A76 1.92GHz + 4x Cortex-A55 1.8GHz), 8GB RAM, 128GB ROM,40+20+8+TOF/32MP, Dual SIM, 4200mAh, Android 9.0 + EMUI 9.1"),
            new Phone("Samsung", "Galaxy A52", 399, 2, "64 megapixel camera, 4k videokwaliteit 6.5 inch AMOLED scherm 128 GBopslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig(IP67)"),
            new Phone("Apple", "iPhone 11", 619, 3, "Met de dubbele camera schiet je in elke situatie een perfecte foto of videoDe krachtige A13-chipset zorgt voor razendsnelle prestaties Met Face IDhoef je enkel en alleen naar je toestel te kijken om te ontgrendelen Hettoestel heeft een lange accuduur dankzij een energiezuinige processor"),
            new Phone("Google", "Pixel 4a", 411, 4, "12.2 megapixel camera, 4k videokwaliteit 5.81 inch OLED scherm 128 GBopslaggeheugen 3140 mAh accucapaciteit"),
            new Phone("Xiaomi", "Redmi Note 10 Pro", 298, 5, "108 megapixel camera, 4k videokwaliteit 6.67 inch AMOLED scherm 128GB opslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig(IP53)")
    );

    public SendForm init(){
        String[] message = new String[phones.size()];
        for(int i = 0; i < phones.size(); i++){
            Phone p = phones.get(i);
            message[i] = p.getPropertyId() + ". " + p.getMerk() + " " + p.getType();
        }

        return new SendForm("init", message);
    }

    public SendForm search(String input) {
        try {
            String[] message = new String[phones.size()];
            for (int i = 0; i < phones.size(); i++) {
                Phone p = phones.get(i);
                if(p.getType().contains(input) || p.getMerk().contains(input) || p.getBeschrijving().contains(input)){
                    message[i] = p.getPropertyId() + ". " + p.getMerk() + " " + p.getType();
                }
            }
            return new SendForm("search", message);
        } catch (ArrayIndexOutOfBoundsException e) {
            String[] message = {"error"};
            return new SendForm("search", message);
        }
    }

    public SendForm getPhone(String input) {
        try {
            System.out.flush();
            int number = Integer.parseInt(input) - 1;
            Phone phone = phones.get(number);
            String[] message = {phone.getPropertyId() + ". " + phone.getMerk() + " " + phone.getType() + " " + phone.getPrijs() + "<br><br>" + phone.getBeschrijving()};
            return new SendForm("getPhone", message);
        } catch (ArrayIndexOutOfBoundsException e) {
            String[] message = {"er is geen telefoon met dit nummer"};
            return new SendForm("getPhone",message);
        } catch (NumberFormatException e) {
            String[] message = {"input is geen getal voor getPhones"};
        return new SendForm("error",message);
        }

    }
}