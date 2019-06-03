# NavigationApp

navGraph

navGraph
    destination-fragmentNavigation

 classpath 'android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha02'

1.
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    
    <item
        android:id="@id/menu1_fragment"
        android:title="@string/menu1_title"/>
    <item
        android:id="@id/menu2_fragment"
        android:title="@string/menu2_title"/>
</menu>
id 对应navigation的id

2.
<action android:id="@+id/action_livedata_fragment_to_livedata2_fragment"
            app:destination="@id/menu2_next_fragment"
            app:enterAnim="@anim/slide_in_right"
            app:exitAnim="@anim/slide_out_left"
            app:popEnterAnim="@anim/slide_in_left"
            app:popExitAnim="@anim/slide_out_right" />
action的id 和 destination:
id 就是这个 action 的 id,
destination 是目的地，要跳转到哪里的
还可以设置动画

3.
要跳转到第二个 Fragment 得使用NavController
来发起页面跳转，可以通过以下方法获取NavController:

NavHostFragment.findNavController(Fragment)
Navigation.findNavController(Activity, @IdRes int viewId)

Navigation.findNavController(View)
获取到NavController后，就可以通过它的navigate()方法发起页面跳转，navigate()接受action id 或 fragment id 以及导航选项及Bundle参数等作为参数。




