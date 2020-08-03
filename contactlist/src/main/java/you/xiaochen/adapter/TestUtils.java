package you.xiaochen.adapter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import you.xiaochen.R;
import you.xiaochen.search.Contact;

/**
 * Created by you on 2017/9/11.
 */

public class TestUtils {

    public static List<Contact> contactList(Context context) {
        List<Contact> contactList = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        String[] names = context.getResources().getStringArray(R.array.names);
        for (int i = 0; i < names.length; i++) {
            int urlIndex = random.nextInt(URLS.length - 1);
            int url = URLS[urlIndex];
            contactList.add(new Contact(names[i], url));
        }
        return contactList;
    }


    static int[] URLS = {R.drawable.header0, R.drawable.header1, R.drawable.header2, R.drawable.header3};

}
