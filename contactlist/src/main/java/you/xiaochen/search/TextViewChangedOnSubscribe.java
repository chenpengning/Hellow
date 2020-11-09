/*
package you.xiaochen.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

*/
/**
 * Created by you on 2017/4/10.
 *//*


public class TextViewChangedOnSubscribe implements Observable.OnSubscribe<String> {

    private TextView mTextView;

    public void addTextViewWatcher(TextView mTextView) {
        this.mTextView = mTextView;
    }

    @Override
    public void call(final Subscriber<? super String> subscriber) {
        final TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(s.toString().trim());
                }
            }
        };
        mTextView.addTextChangedListener(watcher);
        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                mTextView.removeTextChangedListener(watcher);
            }
        });
    }

}
*/
