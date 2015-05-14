// Generated code from Butter Knife. Do not modify!
package com.example.doubledrawerlayout;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MainActivity$$ViewInjector<T extends com.example.doubledrawerlayout.MainActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230720, "field 'mindrawer'");
    target.mindrawer = finder.castView(view, 2131230720, "field 'mindrawer'");
    view = finder.findRequiredView(source, 2131230721, "field 'mainlayout'");
    target.mainlayout = finder.castView(view, 2131230721, "field 'mainlayout'");
  }

  @Override public void reset(T target) {
    target.mindrawer = null;
    target.mainlayout = null;
  }
}
