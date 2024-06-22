package io.github.orionlibs.core.web.download;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.runnable.OrionJob;
import java.io.IOException;
import org.jsoup.Jsoup;

public class ImageURLDownloadService extends OrionService implements OrionJob
{
    /*public static void main(String[] args)
    {
        String x = "https://www.baeldung.com/full_archive?__cf_chl_tk=5rMWRWvoszeNprX_IQpW3iU8liOqJ5H5FKpVe0DXZAU-1688145510-0-gaNycGzNCqU";
        String y = "https://www.baeldung.com/";
        List<String> issues = new ArrayList<>();
        for(int i = 182; i <= 495; i++)
        {
            try
            {
                FileService.downloadFile(x + i, "D:/downloads/dev/newsletter-articles/baeldung/" + i + ".html");
                System.out.println("done " + i);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }*/
    /*public static void main(String[] args)
    {
    
        try
        {
            Jsoup.connect("https://mathworld.wolfram.com/letters/A.html").get().select("ul.topics-list").select("a").forEach(link -> System.out.println(link.text()));
        }
        catch(IOException e)
        {
        }
    
    }*/
    private String baseURL;


    public ImageURLDownloadService(String baseURL)
    {
        this.baseURL = baseURL;
    }


    public void download()
    {

        try
        {
            Jsoup.connect(baseURL).get().select("a").forEach(link -> System.out.println(link.attr("abs:href")));
            //Jsoup.connect(baseURL).get().select("img").forEach(link -> System.out.println(link.attr("abs:src")));
        }
        catch(IOException e)
        {
        }

    }


    @Override
    public void run()
    {
        download();
    }
}