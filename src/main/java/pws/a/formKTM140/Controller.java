/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.formKTM140;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MADD
 */
public class Controller 
{
    @RequestMapping("/nexthalaman")
    public String getData(
                @RequestParam(value = "nama") String data1,
                @RequestParam(value = "nim") String data2,
                @RequestParam(value = "tanggallahir")@DateTimeFormat(pattern="yyyy-MM-dd") Date data3,
                @RequestParam(value = "program") String data4,
                @RequestParam(value = "jurusan") String data5,
                @RequestParam(value = "angkatan") String data6,
                @RequestParam(value = "email") String data7,
                @RequestParam(value = "foto") MultipartFile data8,
                Model Kurir
                )throws IOException
    {
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String newTanggal = tanggal.format(data3);
        
        String fotostringbase64 = Base64.encodeBase64String(data8.getBytes());
        String fotopath = "data:image/png;base64,".concat(fotostringbase64);
        
        Kurir.addAttribute("paket1", data1);
        Kurir.addAttribute("paket2", data2);
        Kurir.addAttribute("paket3", newTanggal);
        Kurir.addAttribute("paket4", data4);
        Kurir.addAttribute("paket5", data5);
        Kurir.addAttribute("paket6", data6);
        Kurir.addAttribute("paket7", data7);
        Kurir.addAttribute("paket8", fotopath);
        return "viewpage";
    }    
}
