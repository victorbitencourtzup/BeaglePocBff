package br.com.beagle.sample.vtbitencourt.bff.custom.actions

import br.com.zup.beagle.annotation.RegisterAction
import br.com.zup.beagle.widget.action.Action

@RegisterAction
class CustomNavigateRemoteAction (val url: br.com.zup.beagle.widget.context.Bind<String>) : Action