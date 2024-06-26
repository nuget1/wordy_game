#############################################################################
# Generated by PAGE version 7.6
#  in conjunction with Tcl version 8.6
#  May 20, 2023 03:12:00 PM CST  platform: Windows NT
set vTcl(timestamp) ""
if {![info exists vTcl(borrow)]} {
    ::vTcl::MessageBox -title Error -message  "You must open project files from within PAGE."
    exit}


set image_list { 
}
vTcl:create_project_images $image_list   ;# In image.tcl

if {!$vTcl(borrow) && !$vTcl(template)} {

set vTcl(actual_gui_font_dft_desc)  TkDefaultFont
set vTcl(actual_gui_font_dft_name)  TkDefaultFont
set vTcl(actual_gui_font_text_desc)  TkTextFont
set vTcl(actual_gui_font_text_name)  TkTextFont
set vTcl(actual_gui_font_fixed_desc)  TkFixedFont
set vTcl(actual_gui_font_fixed_name)  TkFixedFont
set vTcl(actual_gui_font_menu_desc)  TkMenuFont
set vTcl(actual_gui_font_menu_name)  TkMenuFont
set vTcl(actual_gui_font_tooltip_desc)  TkDefaultFont
set vTcl(actual_gui_font_tooltip_name)  TkDefaultFont
set vTcl(actual_gui_font_treeview_desc)  TkDefaultFont
set vTcl(actual_gui_font_treeview_name)  TkDefaultFont
########################################### 
set vTcl(actual_gui_bg) #d9d9d9
set vTcl(actual_gui_fg) #000000
set vTcl(actual_gui_analog) #ececec
set vTcl(actual_gui_menu_analog) #ececec
set vTcl(actual_gui_menu_bg) #d9d9d9
set vTcl(actual_gui_menu_fg) #000000
set vTcl(complement_color) gray40
set vTcl(analog_color_p) #c3c3c3
set vTcl(analog_color_m) beige
set vTcl(tabfg1) black
set vTcl(tabfg2) black
set vTcl(actual_gui_menu_active_bg)  #ececec
set vTcl(actual_gui_menu_active_fg)  #000000
########################################### 
set vTcl(pr,autoalias) 1
set vTcl(pr,relative_placement) 1
set vTcl(mode) Relative
}




proc vTclWindow.top1 {base} {
    global vTcl
    if {$base == ""} {
        set base .top1
    }
    if {[winfo exists $base]} {
        wm deiconify $base; return
    }
    set top $base
    set target $base
    ###################
    # CREATING WIDGETS
    ###################
    vTcl::widgets::core::toplevel::createCmd $top -class Toplevel \
        -background $vTcl(actual_gui_bg) \
        -highlightbackground $vTcl(actual_gui_bg) -highlightcolor black 
    wm focusmodel $top passive
    wm geometry $top 600x450+468+138
    update
    # set in toplevel.wgt.
    global vTcl
    global img_list
    set vTcl(save,dflt,origin) 0
    wm maxsize $top 1540 845
    wm minsize $top 120 1
    wm overrideredirect $top 0
    wm resizable $top 1 1
    wm deiconify $top
    set toptitle "Best Players in Wordy"
    wm title $top $toptitle
    namespace eval ::widgets::${top}::ClassOption {}
    set ::widgets::${top}::ClassOption(-toptitle) $toptitle
    vTcl:DefineAlias "$top" "best_players_frame" vTcl:Toplevel:WidgetProc "" 1
    set vTcl(real_top) {}
    label "$top.lab47" \
        -activebackground #f9f9f9 -activeforeground SystemButtonText \
        -anchor w -background $vTcl(actual_gui_bg) -compound left \
        -disabledforeground #a3a3a3 -font "TkDefaultFont" \
        -foreground $vTcl(actual_gui_fg) \
        -highlightbackground $vTcl(actual_gui_bg) -highlightcolor black \
        -text "Best Players" 
    vTcl:DefineAlias "$top.lab47" "best_players_label" vTcl:WidgetProc "best_players_frame" 1
### SPOT dump_widget_opt A
    ttk::style configure Treeview \
         -font  "$vTcl(actual_gui_font_treeview_desc)"
    vTcl::widgets::ttk::scrolledtreeview::CreateCmd "$top.scr48" \
        -background $vTcl(actual_gui_bg) -height 15 \
        -highlightbackground $vTcl(actual_gui_bg) -highlightcolor black \
        -width 30 
    vTcl:DefineAlias "$top.scr48" "best_players_tree_view" vTcl:WidgetProc "best_players_frame" 1
### SPOT dump_widget_opt A

        $base.scr48.01 configure -columns Col1 -height 4
        $base.scr48.01 configure -columns {Col1}
        $base.scr48.01 heading #0 -text {Players}
        $base.scr48.01 heading #0 -anchor center
        $base.scr48.01 column #0 -width 235
        $base.scr48.01 column #0 -minwidth 20
        $base.scr48.01 column #0 -stretch 1
        $base.scr48.01 column #0 -anchor w
        $base.scr48.01 heading Col1 -text {Wins}
        $base.scr48.01 heading Col1 -anchor center
        $base.scr48.01 column Col1 -width 236
        $base.scr48.01 column Col1 -minwidth 20
        $base.scr48.01 column Col1 -stretch 1
        $base.scr48.01 column Col1 -anchor w
    ###################
    # SETTING GEOMETRY
    ###################
    place $top.lab47 \
        -in $top -x 0 -relx 0.1 -y 0 -rely 0.089 -width 0 -relwidth 0.14 \
        -height 0 -relheight 0.069 -anchor nw -bordermode ignore 
    place $top.scr48 \
        -in $top -x 0 -relx 0.1 -y 0 -rely 0.178 -width 0 -relwidth 0.817 \
        -height 0 -relheight 0.527 -anchor nw -bordermode ignore 

    vTcl:FireEvent $base <<Ready>>
}

proc 36 {args} {return 1}


Window show .
set btop1 ""
if {$vTcl(borrow)} {
    set btop1 .bor[expr int([expr rand() * 100])]
    while {[lsearch $btop1 $vTcl(tops)] != -1} {
        set btop1 .bor[expr int([expr rand() * 100])]
    }
}
set vTcl(btop) $btop1
Window show .top1 $btop1
if {$vTcl(borrow)} {
    $btop1 configure -background plum
}

