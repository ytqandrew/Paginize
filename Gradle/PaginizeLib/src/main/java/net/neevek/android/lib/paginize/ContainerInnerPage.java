package net.neevek.android.lib.paginize;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Copyright (c) 2015 neevek <i@neevek.net>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * An InnerPage as the container for other InnerPages
 *
 * @see ContainerPageManager
 * @see ContainerPage
 */
public abstract class ContainerInnerPage extends InnerPage
    implements InnerPageContainer {
  private ContainerPageManager mContainerPageManager;

  public ContainerInnerPage(ViewWrapper innerPageContainer) {
    super(innerPageContainer);
    mContainerPageManager = new ContainerPageManager(this);
  }

  public void setInnerPageEventNotifier(
      InnerPageEventNotifier innerPageEventNotifier) {
    mContainerPageManager.setInnerPageEventNotifier(innerPageEventNotifier);
  }

  public void setInnerPage(InnerPage newPage) {
    mContainerPageManager.setPage(newPage);
  }

  public void unsetInnerPage() {
    mContainerPageManager.unsetPage();
  }

  public InnerPage getCurrentInnerPage() {
    return mContainerPageManager.getCurrentInnerPage();
  }

  @Override
  public ViewGroup getContainerView() {
    return mContainerPageManager.getContainerView();
  }

  @Override
  public void onResume() {
    mContainerPageManager.onResume();
  }

  @Override
  public void onPause() {
    mContainerPageManager.onPause();
  }

  @Override
  public boolean onBackPressed() {
    return mContainerPageManager.onBackPressed();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    mContainerPageManager.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (mContainerPageManager.onKeyDown(keyCode, event)) {
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (mContainerPageManager.onKeyUp(keyCode, event)) {
      return true;
    }
    return super.onKeyUp(keyCode, event);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (mContainerPageManager.onTouchEvent(event)) {
      return true;
    }
    return super.onTouchEvent(event);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    mContainerPageManager.onConfigurationChanged(newConfig);
  }

  @Override
  public void onShow() {
    mContainerPageManager.onShow();
  }

  @Override
  public void onShown() {
    mContainerPageManager.onShown();
  }

  @Override
  public void onHide() {
    mContainerPageManager.onHide();
  }

  @Override
  public void onHidden() {
    mContainerPageManager.onHidden();
  }

  @Override
  public void onCover() {
    mContainerPageManager.onCover();
  }

  @Override
  public void onCovered() {
    mContainerPageManager.onCovered();
  }

  @Override
  public void onUncover(Object arg) {
    mContainerPageManager.onUncover(arg);
  }

  @Override
  public void onUncovered(Object arg) {
    mContainerPageManager.onUncovered(arg);
  }

  @Override
  public void onDestroy() {
    mContainerPageManager.onDestroy();
  }
}
