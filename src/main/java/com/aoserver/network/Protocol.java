package com.aoserver.network;

import com.aoserver.network.packets.ClientPacketID;

public class Protocol {
    private long userIndex;
    private ByteQueue incomingData, outgoingData;

    public Protocol(long userIndex) {
        this.userIndex = userIndex;
        this.incomingData = new ByteQueue();
        this.outgoingData = new ByteQueue();
    }
    
    public void putDataBuffer(final byte[] dataBuffer) {
        incomingData.writeBlock(dataBuffer, -1);
    }


    public void handleIncomingData() {
        byte p = incomingData.peekByte();

        if (p > ClientPacketID.values().length) return;
        ClientPacketID packet = ClientPacketID.values()[p];
        System.out.println(packet + " #" + p);

        switch (packet) {
            case LoginExistingChar: handleLoginExistingChar(); break;
            case ThrowDices: handleThrowDices(); break;
            case LoginNewChar: handleLoginNewChar(); break;
            case Talk: handleTalk(); break;
            case Yell: handleYell(); break;
            case Whisper: handleWhisper(); break;
            case Walk: handleWalk(); break;
            case RequestPositionUpdate: handleRequestPositionUpdate(); break;
            case Attack: handleAttack(); break;
            case PickUp: handlePickUp(); break;
            case SafeToggle: handleSafeToggle(); break;
            case ResuscitationSafeToggle: handleResuscitationToggle(); break;
            case RequestGuildLeaderInfo: handleRequestGuildLeaderInfo(); break;
            case RequestAtributes: handleRequestAtributes(); break;
            case RequestFame: handleRequestFame(); break;
            case RequestSkills: handleRequestSkills(); break;
            case RequestMiniStats: handleRequestMiniStats(); break;
            case CommerceEnd: handleCommerceEnd(); break;
            case CommerceChat: handleCommerceChat(); break;
            case UserCommerceEnd: handleUserCommerceEnd();
            case UserCommerceConfirm: handleUserCommerceConfirm(); break;
            case BankEnd: handleBankEnd(); break;
            case UserCommerceOk: handleUserCommerceOk(); break;
            case UserCommerceReject: handleUserCommerceReject(); break;
            case Drop: handleDrop(); break;
            case CastSpell: handleCastSpell(); break;
            case LeftClick: handleLeftClick(); break;
            case DoubleClick: handleDoubleClick(); break;
            case Work: handleWork(); break;
            case UseSpellMacro: handleUseSpellMacro(); break;
            case UseItem: handleUseItem(); break;
            case CraftBlacksmith: handleCraftBlacksmith(); break;
            case CraftCarpenter: handleCraftCarpenter(); break;
            case WorkLeftClick: handleWorkLeftClick(); break;
            case CreateNewGuild: handleCreateNewGuild(); break;
            case SpellInfo: handleSpellInfo(); break;
            case EquipItem: handleEquipItem(); break;
            case ChangeHeading: handleChangeHeading(); break;
            case ModifySkills: handleModifySkills(); break;
            case Train: handleTrain(); break;
            case CommerceBuy: handleCommerceBuy(); break;
            case BankExtractItem: handleBankExtractItem(); break;
            case CommerceSell: handleCommerceSell(); break;
            case BankDeposit: handleBankDeposit(); break;
            case ForumPost: handleForumPost(); break;
            case MoveSpell: handleMoveSpell(); break;
            case MoveBank: handleMoveBank(); break;
            case ClanCodexUpdate: handleClanCodexUpdate(); break;
            case UserCommerceOffer: handleUserCommerceOffer(); break;
            case GuildAcceptPeace: handleGuildAcceptPeace(); break;
            case GuildRejectAlliance: handleGuildRejectAlliance(); break;
            case GuildRejectPeace: handleGuildRejectPeace(); break;
            case GuildAcceptAlliance: handleGuildAcceptAlliance(); break;
            case GuildOfferPeace: handleGuildOfferPeace(); break;
            case GuildOfferAlliance: handleGuildOfferAlliance(); break;
            case GuildAllianceDetails: handleGuildAllianceDetails(); break;
            case GuildPeaceDetails: handleGuildPeaceDetails(); break;
            case GuildRequestJoinerInfo: handleGuildRequestJoinerInfo(); break;
            case GuildAlliancePropList: handleGuildAlliancePropList(); break;
            case GuildPeacePropList: handleGuildPeacePropList(); break;
            case GuildDeclareWar: handleGuildDeclareWar(); break;
            case GuildNewWebsite: handleGuildNewWebsite(); break;
            case GuildAcceptNewMember: handleGuildAcceptNewMember(); break;
            case GuildRejectNewMember: handleGuildRejectNewMember(); break;
            case GuildKickMember: handleGuildKickMember(); break;
            case GuildUpdateNews: handleGuildUpdateNews(); break;
            case GuildMemberInfo: handleGuildMemberInfo(); break;
            case GuildOpenElections: handleGuildOpenElections(); break;
            case GuildRequestMembership: handleGuildRequestMembership(); break;
            case GuildRequestDetails: handleGuildRequestDetails(); break;
            case Online: handleOnline(); break;
            case Quit: handleQuit(); break;
            case GuildLeave: handleGuildLeave(); break;
            case RequestAccountState: handleRequestAccountState(); break;
            case PetStand: handlePetStand(); break;
            case PetFollow: handlePetFollow(); break;
            case ReleasePet: handleReleasePet(); break;
            case TrainList: handleTrainList(); break;
            case Rest: handleRest(); break;
            case Meditate: handleMeditate(); break;
            case Resucitate: handleResucitate(); break;
            case Heal: handleHeal(); break;
            case Help: handleHelp(); break;
            case RequestStats: handleRequestStats(); break;
            case CommerceStart: handleCommerceStart(); break;
            case BankStart: handleBankStart(); break;
            case Enlist: handleEnlist(); break;
            case Information: handleInformation(); break;
            case Reward: handleReward(); break;
            case RequestMOTD: handleRequestMOTD(); break;
            case Uptime: handleUpTime(); break;
            case PartyLeave: handlePartyLeave(); break;
            case PartyCreate: handlePartyCreate(); break;
            case PartyJoin: handlePartyJoin(); break;
            case Inquiry: handleInquiry(); break;
            case GuildMessage: handleGuildMessage(); break;
            case PartyMessage: handlePartyMessage(); break;
            case CentinelReport: handleCentinelReport(); break;
            case GuildOnline: handleGuildOnline(); break;
            case PartyOnline: handlePartyOnline(); break;
            case CouncilMessage: handleCouncilMessage(); break;
            case RoleMasterRequest: handleRoleMasterRequest(); break;
            case GMRequest: handleGMRequest(); break;
            case bugReport: handleBugReport(); break;
            case ChangeDescription: handleChangeDescription();  break;
            case GuildVote: handleGuildVote(); break;
            case Punishments: handlePunishments(); break;
            case ChangePassword: handleChangePassword(); break;
            case Gamble: handleGamble(); break;
            case InquiryVote: handleInquiryVote(); break;
            case LeaveFaction: handleLeaveFaction(); break;
            case BankExtractGold: handleBankExtractGold(); break;
            case BankDepositGold: handleBankDepositGold(); break;
            case Denounce: handleDenounce(); break;
            case GuildFundate: handleGuildFundate(); break;
            case GuildFundation: handleGuildFundation(); break;
            case PartyKick: handlePartyKick(); break;
            case PartySetLeader: handlePartySetLeader(); break;
            case PartyAcceptMember: handlePartyAcceptMember(); break;
            case Ping: handlePing(); break;
            case RequestPartyForm: handlePartyForm(); break;
            case ItemUpgrade: handleItemUpgrade(); break;
            case GMCommands: handleGMCommands(); break;
            case InitCrafting: handleInitCrafting(); break;
            case Home: handleHome(); break;
            case ShowGuildNews: handleShowGuildNews(); break;
            case ShareNpc: handleShareNpc(); break;
            case StopSharingNpc: handleStopSharingNpc(); break;
            case Consulta: handleConsultation(); break;
            default:
                return;
        }

        // Done with this packet, move on to next one
        if (incomingData.length() > 0) {
            handleIncomingData();
        }

    }

    private void handlePickUp() {
    }

    private void handleAttack() {
    }

    private void handleRequestPositionUpdate() {
    }

    private void handleWalk() {
    }

    private void handleWhisper() {
    }

    private void handleYell() {
    }

    private void handleTalk() {
    }

    private void handleLoginNewChar() {
    }

    private void handleThrowDices() {
        
    }

    private void handleConsultation() {
    }

    private void handleStopSharingNpc() {
    }

    private void handleShareNpc() {
    }

    private void handleShowGuildNews() {
    }

    private void handleHome() {
    }

    private void handleInitCrafting() {
    }

    private void handleGMCommands() {
    }

    private void handleItemUpgrade() {
    }

    private void handlePartyForm() {
    }

    private void handlePing() {
    }

    private void handlePartyAcceptMember() {
    }

    private void handlePartySetLeader() {
    }

    private void handlePartyKick() {
    }

    private void handleGuildFundation() {
    }

    private void handleGuildFundate() {
    }

    private void handleDenounce() {
    }

    private void handleBankDepositGold() {
    }

    private void handleBankExtractGold() {
    }

    private void handleLeaveFaction() {
    }

    private void handleInquiryVote() {
    }

    private void handleGamble() {
    }

    private void handleChangePassword() {
    }

    private void handlePunishments() {
    }

    private void handleGuildVote() {
    }

    private void handleChangeDescription() {
    }

    private void handleBugReport() {
    }

    private void handleGMRequest() {
    }

    private void handleRoleMasterRequest() {
    }

    private void handleCouncilMessage() {
    }

    private void handlePartyOnline() {
    }

    private void handleGuildOnline() {
    }

    private void handleCentinelReport() {
    }

    private void handlePartyMessage() {
    }

    private void handleGuildMessage() {
    }

    private void handleInquiry() {
    }

    private void handlePartyJoin() {
    }

    private void handlePartyCreate() {
    }

    private void handlePartyLeave() {
    }

    private void handleUpTime() {
    }

    private void handleRequestMOTD() {
    }

    private void handleReward() {
    }

    private void handleInformation() {
    }

    private void handleEnlist() {
    }

    private void handleBankStart() {
    }

    private void handleCommerceStart() {
    }

    private void handleRequestStats() {
    }

    private void handleHelp() {
    }

    private void handleHeal() {
    }

    private void handleResucitate() {
    }

    private void handleMeditate() {
    }

    private void handleRest() {
    }

    private void handleTrainList() {
    }

    private void handleReleasePet() {
    }

    private void handlePetFollow() {
    }

    private void handlePetStand() {
    }

    private void handleRequestAccountState() {
    }

    private void handleGuildLeave() {
    }

    private void handleQuit() {
    }

    private void handleOnline() {
    }

    private void handleGuildRequestDetails() {
    }

    private void handleGuildRequestMembership() {
    }

    private void handleGuildOpenElections() {
    }

    private void handleGuildMemberInfo() {
    }

    private void handleGuildUpdateNews() {
    }

    private void handleGuildKickMember() {
    }

    private void handleGuildRejectNewMember() {
    }

    private void handleGuildAcceptNewMember() {
    }

    private void handleGuildNewWebsite() {
    }

    private void handleGuildDeclareWar() {
    }

    private void handleGuildPeacePropList() {
    }

    private void handleGuildAlliancePropList() {
    }

    private void handleGuildRequestJoinerInfo() {
    }

    private void handleGuildPeaceDetails() {
    }

    private void handleGuildAllianceDetails() {
    }

    private void handleGuildOfferAlliance() {
    }

    private void handleGuildOfferPeace() {
    }

    private void handleGuildAcceptAlliance() {
    }

    private void handleGuildRejectPeace() {
    }

    private void handleGuildRejectAlliance() {
    }

    private void handleGuildAcceptPeace() {
    }

    private void handleUserCommerceOffer() {
    }

    private void handleClanCodexUpdate() {
    }

    private void handleMoveSpell() {
    }

    private void handleMoveBank() {
    }

    private void handleForumPost() {
    }

    private void handleBankDeposit() {
    }

    private void handleCommerceSell() {
    }

    private void handleBankExtractItem() {
    }

    private void handleCommerceBuy() {
    }

    private void handleTrain() {
    }

    private void handleModifySkills() {
    }

    private void handleChangeHeading() {
    }

    private void handleEquipItem() {
    }

    private void handleSpellInfo() {
    }

    private void handleCreateNewGuild() {
    }

    private void handleWorkLeftClick() {
    }

    private void handleCraftCarpenter() {
    }

    private void handleCraftBlacksmith() {
    }

    private void handleUseItem() {
    }

    private void handleUseSpellMacro() {
    }

    private void handleWork() {
    }

    private void handleDoubleClick() {
    }

    private void handleLeftClick() {
    }

    private void handleCastSpell() {
    }

    private void handleDrop() {
    }

    private void handleUserCommerceReject() {
    }

    private void handleUserCommerceOk() {
    }

    private void handleBankEnd() {
    }

    private void handleUserCommerceConfirm() {
    }

    private void handleUserCommerceEnd() {
    }

    private void handleCommerceChat() {
    }

    private void handleCommerceEnd() {
    }

    private void handleRequestMiniStats() {
    }

    private void handleRequestSkills() {
    }

    private void handleRequestFame() {
    }

    private void handleRequestAtributes() {
    }

    private void handleRequestGuildLeaderInfo() {
    }

    private void handleResuscitationToggle() {

    }

    private void handleSafeToggle() {

    }

    private void handleLoginExistingChar() {
        if (incomingData.length() < 6) {
            System.err.println("ERROR" + " en handleLoginExistingChar");
            return;
        }

        ByteQueue buffer = new ByteQueue();
        buffer.copyBuffer(incomingData);

        // Remove packet ID
        buffer.readByte();

        final String userName = buffer.readASCIIString();
        System.out.println("userName = " + userName);
        final String password = buffer.readASCIIString();
        System.out.println("password = " + password);
        final String version = buffer.readByte() + "." + buffer.readByte() + "." + buffer.readByte();


        //If Not AsciiValidos(UserName) Then
        //        Call WriteErrorMsg(UserIndex, "Nombre inválido.")
        //        Call FlushBuffer(UserIndex)
        //        Call CloseSocket(UserIndex)
        //
        //        Exit Sub
        //    End If
        //
        //    If Not PersonajeExiste(UserName) Then
        //        Call WriteErrorMsg(UserIndex, "El personaje no existe.")
        //        Call FlushBuffer(UserIndex)
        //        Call CloseSocket(UserIndex)
        //
        //        Exit Sub
        //    End If
        //If BANCheck(UserName) Then
        //            Call WriteErrorMsg(UserIndex, "Se te ha prohibido la entrada a Argentum Online debido a tu mal comportamiento. Puedes consultar el reglamento y el sistema de soporte desde www.argentumonline.com.ar")
        //        ElseIf Not VersionOK(version) Then
        //            Call WriteErrorMsg(UserIndex, "Esta versión del juego es obsoleta, la versión correcta es la " & ULTIMAVERSION & ". La misma se encuentra disponible en www.argentumonline.com.ar")
        //        Else
        //            Call ConnectUser(UserIndex, UserName, Password)
        //        End If

        incomingData.copyBuffer(buffer);
        System.out.println("LoginExistingChar - FALTA TERMINAR.");
    }
}
